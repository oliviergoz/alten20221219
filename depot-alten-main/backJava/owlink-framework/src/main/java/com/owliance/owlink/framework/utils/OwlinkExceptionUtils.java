package com.owliance.owlink.framework.utils;


import org.springframework.core.NestedRuntimeException;


/**
 * Classe utilitaire pour la gestion des exceptions.
 */
public final class OwlinkExceptionUtils {

    /**
     * Une classe utilitaire ne doit pas être instanciée
     *
     */
    private OwlinkExceptionUtils() {

    }

    /**
     * Renvoie le message d'une exception ou de sa RootCause.
     *
     * @param e NestedRuntimeException
     * @return {@link String}
     */
    public static String getMessage(NestedRuntimeException e) {
        String message;
        Throwable throwable = e.getRootCause();

        if (throwable == null) {
            message = e.getMessage();
        }
        else {
            message = throwable.getMessage();
        }

        return message;
    }

}
