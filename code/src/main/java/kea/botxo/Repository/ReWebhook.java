package kea.botxo.Repository;

import org.springframework.stereotype.Repository;
import kea.botxo.Model.Webhook;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReWebhook {

    public ReWebhook(){}

    public Webhook fetch(int id){

        //dummy data
        Webhook webhook = new Webhook();
        webhook.setName("Nametest");
        webhook.setRespOnError(2);
        webhook.setRespOnSuccess(3);
        webhook.setUrl("https://hej.dk");
        webhook.setBody("bodytest");
        return webhook;
    }

    public List<Webhook> fetchAll(){

        //dummy data
        Webhook webhook = new Webhook();
        webhook.setName("Nametest");
        webhook.setRespOnError(2);
        webhook.setRespOnSuccess(3);
        webhook.setUrl("https://hej.dk");
        webhook.setBody("bodytest");

        Webhook webhook2 = new Webhook();
        webhook2.setName("Nametest2");
        webhook2.setRespOnError(13);
        webhook2.setRespOnSuccess(14);
        webhook2.setUrl("https://hej22222.dk");
        webhook2.setBody("bodytest2");

        List<Webhook> webhooks = new ArrayList<>();
        webhooks.add(webhook);
        webhooks.add(webhook2);
        return webhooks;
    }

}
