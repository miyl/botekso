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

/**
 * The repository (database connection) for Webhooks
 */
@Repository
public class ReWebhook {

    @Autowired
    JdbcTemplate template;

    /**
     * Fetches a specific Webhook given by its ID from the database
     * @author Andreas, Marcus
     * @param id The webhook to retrieve
     * @return The requested webhook
     */
    public Webhook fetch(int id){

        String sql = "SELECT * FROM webhooks WHERE id=?";

        RowMapper<Webhook> rowMapper = new BeanPropertyRowMapper<>(Webhook.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    /**
     * Fetches a list of all Webhooks from the database
     * @author Andreas, Marcus
     * @return The list of all Webhooks
     */
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
    }

    /**
     * Updates a specific Webhook in the database (Unfinished!)
     * @author Andreas, Marcus
     * @param w The Webhook to update
     * @return True if at least one row was updated, otherwise false
     */
    public boolean update(Webhook w){
        //update
        return true;
    }

    /**
     * Deletes a specific Webhook from the database
     * @author Andreas, Marcus
     * @param id The Webhook to delete
     * @return True if at least one row was deleted, otherwise false
     */
    public boolean delete(int id){
        String sql = "DELETE FROM webhooks WHERE id=?";
        return ( template.update(sql, id) != 0 );
    }

    /**
     * Adds a new Webhook to the database
     * @author Andreas, Marcus
     * @param w The Webhook to add
     * @return True if at least one row was added, otherwise false
     */
    public boolean add(Webhook w){
        //TODO: skal fixes som er hardcoded.
        //de 3 sidste.
        String sql = "INSERT INTO webhooks" + 
                "( name, url, body, response_on_success, response_on_error, http_request_type, auth_type, customer_name) VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?);";
        //template.update returns affected rows.
        int res = template.update( sql, w.getName(), w.getUrl(), w.getBody(), w.getResponseOnSuccess(), w.getResponseOnError(), w.getHttpRequestType(), w.getAuthType(), w.getCustomerName() );
        return (res != 0)? true : false;

    }
}
