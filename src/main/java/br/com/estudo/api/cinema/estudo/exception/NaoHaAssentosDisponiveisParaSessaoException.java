package br.com.estudo.api.cinema.estudo.exception;

public class NaoHaAssentosDisponiveisParaSessaoException extends RuntimeException {

    public NaoHaAssentosDisponiveisParaSessaoException(String message){
        super(message);
    }
}
