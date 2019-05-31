package kea.botxo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kea.botxo.models.Webhook;
import kea.botxo.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.sql.Types;

@Repository
public class ReWebhook {

    @Autowired
    JdbcTemplate template;

    public ReWebhook(){}

    public Webhook fetch(int id){

        String sql = "SELECT * FROM webhooks WHERE id=?";

        RowMapper<Webhook> rowMapper = new BeanPropertyRowMapper<>(Webhook.class);
        return template.queryForObject(sql, rowMapper, id);

        //dummy data
        // Webhook webhook = new Webhook();
        // webhook.setName("Nametest");
        // webhook.setResponseOnError(2);
        // webhook.setResponseOnSuccess(3);
        // webhook.setUrl("https://hej.dk");
        // webhook.setBody("bodytest");
        // return webhook;
        // return new Webhook();
    }

    public List<Webhook> fetchAll(){


        //dummy data
        /*
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
        */

        String sql = "SELECT * FROM webhooks";
        RowMapper<Webhook> rowMapper = new BeanPropertyRowMapper<>(Webhook.class);
        return template.query(sql, rowMapper);

        //String sql = "SELECT id, name, url, body, response_on_success, response_on_error, customer AS customerr FROM webhooks";
        //String sql = "SELECT w.id, w.name, w.url, w.body, w.response_on_success, w.response_on_error, c.name, c.tel, c.email FROM webhooks AS w INNER JOIN customers AS c ON w.customer = c.name";
        //// RowMapper<Object> rowMapper = new BeanPropertyRowMapper<>(Object.class);
        //List<Map<String, Object>> query_raw = template.queryForList(sql);
        //List<Webhook> webhooks = new ArrayList<>();

        //for (Map m : query_raw) {
        //  //System.out.println(m.get("id"));
        //  Customer c = new Customer((String) m.get("c.name"), (String) m.get("c.tel"), (String) m.get("c.email"));
        //  Webhook w = new Webhook((int) m.get("w.id"), (String) m.get("w.name"), (String) m.get("w.url"), (String) m.get("w.body"), (int) m.get("w.response_on_success"), (int) m.get("w.response_on_error"), c);
        //  webhooks.add(w);
        //}

        // return webhooks;
    }

    public boolean update(Webhook webhook){
        //update
        return true;
    }

    public boolean delete(int id){
        String sql = "DELETE FROM webhooks WHERE id=?";
        return ( template.update(sql, id) != 0 );
    }

    public boolean add(Webhook webhook){
        //TODO: skal fixes som er hardcoded.
        //de 3 sidste.
        String sql = "INSERT INTO webhooks (" +
                "name, url, body, response_on_success, response_on_error, http_request_type, auth_type, customer) VALUES (" +
                "?, ?, ?, ?, ?, 'POST', 'None', 'Tiger of Sweden');";
        //template.update returns affected rows.
        int res = template.update(sql, webhook.getName(), webhook.getUrl(), webhook.getBody(), webhook.getResponseOnSuccess(), webhook.getResponseOnError());
        return (res != 0)? true : false;

    }


}
