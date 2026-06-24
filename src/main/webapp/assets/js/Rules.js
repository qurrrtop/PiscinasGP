export default class Rules {
        
        static provisions = {
            NAME: {
            type: "string",
            min: 3,
            max: 80,
            regex: /^[A-Za-zÁÉÍÓÚáéíóúÑñ\s'-]+$/
            },
            LAST_NAME: {
                type: "string",
                min: 3,
                max: 50,
                regex: /^[A-Za-zÁÉÍÓÚáéíóúÑñ\s'-]+$/
            },
            EMAIL: {
                type: "string",
                min: 10,
                max: 30,
                regex: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
            },
            PASSWORD: {
                type: "string",
                min: 3,
                max: 255,
                regex: /^[A-Za-z\d@$!%*?&]+$/
            },
            GOALS: {
                type: "numeric",
                min: 0,
                max: 30,
                integer: true
}
        }
}