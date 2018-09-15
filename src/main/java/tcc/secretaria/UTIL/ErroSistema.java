
package tcc.secretaria.UTIL;


public class ErroSistema extends Exception{

    public ErroSistema() {
    }   

    public ErroSistema(String menssagem) {
        super(menssagem);
    }

    public ErroSistema(String menssagem, Throwable causa) {
        super(menssagem, causa);
    }
    
    
}
