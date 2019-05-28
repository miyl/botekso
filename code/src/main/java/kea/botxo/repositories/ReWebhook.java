package kea.botxo.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import kea.botxo.models.Webhook;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReWebhook {

    JdbcTemplate template;

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

    public boolean update(Webhook webhook){
        //update
        return true;
    }

    public boolean delete(int id){
        return true;
    }

    public boolean add(Webhook webhook){
        //TODO: skal fixes som er hardcoded.
        //http_request_type
        //auth_type
        //customer
        String sql = "INSERT INTO webhooks (name, url, body, response_on_success, response_on_error, http_request_type, auth_type, customer) VALUES (?, ?, ?, ?, ?, 'POST', 'None', 'MyTESTCustomer')";

        //template.update returns affected rows.
        if(1 == template.update(sql, webhook.getName(), webhook.getUrl(), webhook.getBody(), webhook.getRespOnSuccess(), webhook.getRespOnError())){
            return true;
        }
        return false;
    }


}