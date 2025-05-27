/**
 * Nome: Principal2.java
 * Descricao: Consulta ao Web Services SOAP dos Correios
 * Author: Lucio A. Rocha
 * Ultima atualizacao: 27/05/2025
 * 
 */

public class Principal2 {
    public static void main(String[] args) {
        System.out.println("Principal: envia mensagem para o servidor");
        
        String soapEndpointUrl = "https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL";
        String soapAction = "http://www.dataaccess.com/webservicesserver/";
        
        SoapClient sc = new SoapClient();
        
        //Requisicao1
        System.out.println("\n---Requisicao1---");
        sc.setCEP("86812460");
        sc.callSoapWebService(soapEndpointUrl, soapAction);
      

        System.out.println("Fim!");
    }
}
