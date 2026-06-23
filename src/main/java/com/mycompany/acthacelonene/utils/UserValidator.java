package com.mycompany.acthacelonene.utils;

import com.mycompany.acthacelonene.exceptions.ValidadorException;

public class UserValidator {
    
    public static void esValidoID ( Long id ) throws ValidadorException {
        if( id != 0 && id <= 0 ) {
            throw new ValidadorException(
                    String.format("El ID: %d ta mal", id)
            );
        }
    }
    
    public String limpiarString( String entry ) {
        if( entry == null ) {
            return null;
        }
        
        return entry.trim();
    }
    
    public static void estaVacioEntry( String entry ) throws ValidadorException {
        if( entry == null || !entry.trim().isEmpty() ) {
            throw new ValidadorException(
                    String.format("la entrada %s ta mal", entry)
            );
        }
    }

    public static void esValidoNombre( String nombre ) throws ValidadorException {
        if ( nombre == null || nombre.isBlank() ) {
            throw new ValidadorException(
                    String.format("el %s ta mal", nombre)
            );
        }
    }
    
}
