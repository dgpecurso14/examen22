package mx.unam.dgpe.sample.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

import io.vertx.core.AbstractVerticle;
import static mx.unam.dgpe.sample.controller.RestUtil.*;

public class TestCalculadora extends AbstractVerticle {
    private static final Logger logger = Logger.getLogger(TestCalculadora.class);
    
    //@Test
    //public void ok() throws Exception {
//        String result = sendGet("https://www.binance.com/api/v3/ticker/price?symbol=BTCUSDT");
  //      logger.info(result);
    //}

    
    @Test
    public void fact() throws Exception {
	/*
    	if(false){  
      String result = sendGet("http://127.0.0.1:8080/api/factorial?b=5");
        logger.info(result);
        assertTrue("de ",result.contains("3"));
        
         result = sendGet("http://127.0.0.1:8080/api/factorial");
        logger.info(result);
        assertTrue("de ",result.contains("-1"));
        
         result = sendGet("http://127.0.0.1:8080/api/factorial?b=5a");
        logger.info(result);
        assertTrue("de ",result.contains("-1"));
        
         result = sendGet("http://127.0.0.1:8080/api/factorial?b=0");
        logger.info(result);
        assertTrue("de ",result.contains("1"));
        
        
         result = sendGet("http://127.0.0.1:8080/api/factorial?b=1");
        logger.info(result);
        assertTrue("de ",result.contains("1"));
        
        
        result = sendGet("http://127.0.0.1:8080/api/factorial?b=10");
        logger.info(result);
        assertTrue("de ",result.contains("7"));
        
        
        result = sendGet("http://127.0.0.1:8080/api/factorial?b=158");
        logger.info(result);
        assertTrue("de ",result.contains("281"));
        }
	*/
    }

   /* @Test
    public void suma() throws Exception {
	
    	if(true){  
      String result = sendGet("http://127.0.0.1:8081/api/suma?a=1&b=2");
        logger.info(result);
        assertTrue("con bvg",result.contains("3"));

        result = sendGet("http://127.0.0.1:8081/api/suma?a=1&b=2");
        logger.info(result);
        assertTrue("Suma",result.contains("3"));

        result = sendGet("http://127.0.0.1:8081/api/suma?a=1&b=a");
        logger.info(result);
        assertTrue("Suma valores incorrectos",result.contains("valores"));

        result = sendGet("http://127.0.0.1:8081/api/rest?a=1&b=1");
        logger.info(result);
        assertTrue("Suma valores incorrectos",result.contains("0"));
        result = sendGet("http://127.0.0.1:8081/api/rest?a=1&b=a");
        logger.info(result);
        assertTrue("Suma valores incorrectos",result.contains("valores"));


        result = sendGet("http://127.0.0.1:8081/api/rest?a=3&b=3");
        logger.info(result);
        assertTrue("Suma valores incorrectos",result.contains("0"));
        result = sendGet("http://127.0.0.1:8081/api/rest?a=1&b=a");
        logger.info(result);
        assertTrue("Suma valores incorrectos",result.contains("valores"));

        result = sendGet("http://127.0.0.1:8081/api/div?a=1&b=1");
        logger.info(result);
        assertTrue("Suma valores incorrectos",result.contains("1"));
        result = sendGet("http://127.0.0.1:8081/api/div?a=1&b=a");
        logger.info(result);
        assertTrue("Suma valores incorrectos",result.contains("valores"));
        result = sendGet("http://127.0.0.1:8081/api/div?a=1&b=0");
        logger.info(result);
        assertTrue("Suma valores incorrectos",result.contains("Inexistente"));


    }*/


}
