package com.lucastrodev.gerenciadorDeVendas.servicos;

import com.lucastrodev.gerenciadorDeVendas.repositorios.VendaRepositorio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EnviadorDeSms {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private VendaRepositorio vendaRepositorio;

    public void enviar(Long idVenda) {

        var venda = vendaRepositorio.findById(idVenda).get();
        var dataEmString = venda.getDataDaVenda().getMonthValue() + "/" + venda.getDataDaVenda().getYear();
        var mensagemParaEnviar = "O vendedor " + venda.getNomeVendedor() + " foi destaque de vendas em " + dataEmString +
                " com um total de R$ " + String.format("%.2f", venda.getTotalDaVenda());

        Twilio.init(twilioSid, twilioKey);

        var mensagemDe = new PhoneNumber(twilioPhoneTo);
        var mensagemPara = new PhoneNumber(twilioPhoneFrom);

        var mensagem = Message.creator(mensagemDe, mensagemPara, mensagemParaEnviar).create();

        System.out.println(mensagem.getSid());
    }
}