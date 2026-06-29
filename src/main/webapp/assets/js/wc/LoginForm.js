import Rules from '../Rules.js';
import SetValidator from '../SetValidator.js';

class Auth extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.basePath = "";
    }
    
    connectedCallback() {
        this.basePath = this.getAttribute('base-path') || "";
        this.render();      
        this.setupListeners();
        
        const error = this.getAttribute("error-message");
        if( error ) {
            this.showCustomAlert("Error", error);
        }
    }
    
    setupListeners() {
        // Para optimizar la captura de datos del formulario, es mejor usar 
        // FormData que ir buscando input por input
        // Reemplazamos esta linae const btnSubmit = this.shadowRoot.querySelector('.btn');
        const form = this.shadowRoot.querySelector('form');
        
        // es mejor que el formulario maneje sbmit y no click
        form?.addEventListener('submit', (e) => this.handlerAccess(e) );
        
        const btnCloseAlert = this.shadowRoot.querySelector('#close-alert');
        btnCloseAlert?.addEventListener('click', () => {
           this.shadowRoot.querySelector('#modal-overlay').classList.add('hidden'); 
           
           const passwordInput = this.shadowRoot.querySelector('#plainPassword');
           if( passwordInput ) {
                passwordInput.value = ""; // Limpiamos solo la contraseña
                passwordInput.focus();    // Le devolvemos el cursor para que vuelva a escribir
           }
        });
        
        // Mapeo de inputs con sus respecitvas reglas
        const fields = [
            { input: '#email', rule: Rules.provisions.EMAIL },
            { input: '#plainPassword', rule: Rules.provisions.PLAIN_PASSWORD }
        ];
        
        // Validación en tiempo real (lado usuario)
        fields.forEach( field => {
           const input = this.shadowRoot.querySelector(field.input);
           
           input?.addEventListener('input', () => {            
               const error = SetValidator.validate(
                   input.value,
                   field.rule
               );
       
               this.checkResult( input, error );
           });
        });
    }
    
    checkResult( inputElement, error ) {
        
        const container = inputElement.closest('.inlet-container');
        if( !container ) return;
        
        const errorMessage = container.querySelector('.error-message');
        
        if( error ) {
            errorMessage.textContent = error;
            errorMessage.classList.remove('hidden');
            
        } else {
            errorMessage.textContent = "";
            errorMessage.classList.add('hidden');
        }
    }
    
    handlerAccess(e) {
        e.preventDefault(); // Frenamos el envío nativo/recarga de página
        
        // Elementos HTML
        const form = this.shadowRoot.querySelector('form');
        const emailInput = this.shadowRoot.querySelector('#email');
        const passwordInput = this.shadowRoot.querySelector('#plainPassword');
         
        // CAPTURA: FormData lee el estado exacto y real de los inputs en el DOM al hacer submit
        const formData = new FormData(form);
        const emailValue = formData.get('email'); // Usa el atributo 'name="email"' del HTML
        const passwordValue = formData.get('plainPassword'); // Usa el atributo 'name="password"' del HTML
        
        // Forzamos la validación de ambos campos al intentar buildear el acceso
        const errorEmail = SetValidator.validate(
            emailValue,
            Rules.provisions.EMAIL
        );

        const errorPassword = SetValidator.validate(
            passwordValue,
            Rules.provisions.PLAIN_PASSWORD
        );

        // Pintamos los resultados en la UI
        this.checkResult( emailInput, errorEmail);
        this.checkResult( passwordInput, errorPassword);
        
        // frenamos si hay error
        if( errorEmail || errorPassword) {
            return;
        }
        
        // Ya no necesitamos que el control se haga en js
        //this.validateAccess( emailValue, passwordValue ); 
        
        form.submit(); // Ahora la validaciones se la dejamos al servidor
    }
    
    /*validateAccess( email, password ) {
        // Simulación de credenciales de roles
        const USER_COORDINADOR = { email: "correo@coordinador.com", password: "Coord123!" };     
        const USER_TEACHER = { email: "correo@profesor.com", password: "Teacher123!" };    
        const USER_STUDENT = { email: "correo@estudiante.com", password: "Student123!" };
        
        if( email === USER_COORDINADOR.email && password === USER_COORDINADOR.password ) {
            this.showCustomAlert("Información", "Acceso correcto, Bienvenido!!!");
            window.location.href = `${this.basePath}/views/home.jsp`;
            
        } else {
            this.showCustomAlert("Error!!!", "Usuario o contraseñas incorrectos. Intente de nuevo");
        }
    }*/
    
    showCustomAlert( title, message ) {
        this.shadowRoot.querySelector('#title-message').textContent = title;
        this.shadowRoot.querySelector('#alert-message').textContent = message;
        
        this.shadowRoot.querySelector('#modal-overlay').classList.remove('hidden');
    }
    
    render() {
        this.shadowRoot.innerHTML = `
            <style>
            * {
                box-sizing: border-box;
            }

            .wrapper {
                position: relative;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                width: 100%;
                min-height: 100vh;
                background-image: url('${this.basePath}/assets/img/fondo-agua.jpg');
                background-size: cover;
                background-position: center;
                overflow: hidden;
                font-family: 'Segoe UI', Arial, sans-serif;
            }

            .brand-corner {
                font-family: 'Segoe UI', Arial, sans-serif;
                position: absolute;
                top: 24px;
                left: 28px;
                display: flex;
                align-items: center;
                gap: 10px;
                z-index: 2;
            }

            .brand-corner img {
                height: 50px;
                width: auto;
                filter: drop-shadow(0 5px 2px rgba(0, 0, 0, .5));
            }

            .brand-corner p {
                color: white;
                font-weight: bold;
                font-size: 17px;
                margin: 0;
                letter-spacing: 0.3px;
                text-shadow: 0 2px 5px rgba(0,0,0,0.4);
            }

            .center-card {
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 100%;
                max-width: 440px;
                padding: 0 20px;
                z-index: 1;
            }

            .center-card > img {
                width: 270px;
                margin-bottom: 28px;
                filter: drop-shadow(0 4px 3px rgba(0,0,0,0.5));
            }

            .titulo {
                color: white;
                font-size: 24px;
                font-weight: bold;
                margin: 0 0 8px;
                text-align: center;
            }

            .subtitulo {
                color: rgba(255,255,255,0.85);
                font-size: 14px;
                margin: 0 0 28px;
                text-align: center;
            }

            form {
                width: 100%;
                display: flex;
                flex-direction: column;
                gap: 18px;
                border: solid 1px rgba(26, 141, 181, 1);
                padding: 30px;
                border-radius: 10px;
                background-color: rgba(26, 141, 181, .10);
            }

            .inlet-container {
                display: flex;
                flex-direction: column;
                gap: 4px;
            }

            .input-icon {
                display: flex;
                align-items: center;
                gap: 12px;
                background: rgba(255,255,255,0.01);
                border: 1px solid rgba(255,255,255,0.35);
                border-radius: 8px;
                padding: 10px 16px;
            }

            .input-icon svg {
                flex-shrink: 0;
                opacity: 0.85;
            }

            input[type="email"],
            input[type="password"] {
                border: none;
                background: transparent;
                color: white;
                font-size: 14px;
                width: 100%;
                outline: none;
            }

            input::placeholder {
                color: rgba(255,255,255,0.65);
                text-transform: uppercase;
                font-size: 12px;
                letter-spacing: 0.5px;
            }

            .error-message {
                color: #ffb3b3;
                font-size: 12px;
                font-weight: bold;
                margin-left: 10px;
                min-height: 14px;
            }

            .btn {
                width: 100%;
                border: none;
                border-radius: 5px;
                font-weight: bold;
                font-size: 15px;
                letter-spacing: 1px;
                padding: 10px 16px;
                cursor: pointer;
                color: white;
                background: rgba(60, 176, 216, 1);
                text-transform: uppercase;
                margin-top: 4px;
            }

            .btn:hover {
                transition: all 0.3s ease;
                filter: brightness(1.08);
            }

            /* Modal de alerta */
            #modal-overlay {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
                z-index: 1000;
                background-color: rgba(0, 0, 0, 0.6);
            }

            #custom-alert {
                background-color: white;
                padding: 20px;
                border-radius: 12px;
                text-align: center;
                box-shadow: 0 10px 30px rgba(0, 0, 0, 0.5);
                min-width: 300px;
            }

            #close-alert {
                margin-top: 15px;
                padding: 8px 20px;
                cursor: pointer;
                border-radius: 8px;
                border: none;
                background: #22d3ee;
                font-weight: bold;
                color: #033a3a;
            }

            .hidden {
                display: none !important;
            }
        </style>

        <div id="modal-overlay" class="hidden">
            <div id="custom-alert">
                <h3 id="title-message"></h3>
                <p id="alert-message"></p>
                <button type="button" id="close-alert" aria-label="Cerrar ventana emergente">Ok</button>
            </div>
        </div>

        <div class="brand-corner">
            <img src="${this.basePath}/assets/img/logos/logo-empresa-celeste.png" alt="Icono GP" />
            <p>PiscinasGP</p>
        </div>

        <div class="wrapper">

            <div class="center-card">
                <img src="${this.basePath}/assets/img/logos/logo-empresa-horizontal.png" alt="Logo GP" />

                <p class="titulo">Iniciar sesión</p>
                <p class="subtitulo">Inicie sesión y comience a utilizar el sistema!</p>

                <form action="${this.basePath}/auth/login" method="post">
                    <div class="inlet-container">
                        <div class="input-icon">
                            <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="white" stroke-width="2"><circle cx="12" cy="8" r="4"/><path d="M4 20c0-4 4-6 8-6s8 2 8 6"/></svg>
                            <input type="email" id="email" name="email" placeholder="EMAIL" required />
                        </div>
                        <small class="error-message hidden"></small>
                    </div>

                    <div class="inlet-container">
                        <div class="input-icon">
                            <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="white" stroke-width="2"><rect x="5" y="11" width="14" height="9" rx="2"/><path d="M8 11V7a4 4 0 118 0v4"/></svg>
                            <input type="password" id="plainPassword" name="plainPassword" placeholder="PASSWORD" required />
                        </div>
                        <small class="error-message hidden"></small>
                    </div>

                    <button type="submit" class="btn" aria-label="Verificar acceso">LOGIN</button>
                </form>
            </div>

        </div>
    `;
    }
}

customElements.define('login-form', Auth);