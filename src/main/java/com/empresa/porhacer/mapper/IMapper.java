package com.empresa.porhacer.mapper;

public interface IMapper<I, O> {
    //Método generico nos permite agilizar el código
    //Metodo en la interfaz que nos permite mapeardetodo lo que entremos por In a Out
    public O map(I in);
}
