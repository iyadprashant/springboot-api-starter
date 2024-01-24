package com.api.org.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;

@Component
public class MongoDBRepo {

	@Autowired
	private MongoTemplate mongo;
	

	public List<Map> read(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		
		
		Pageable pageable = PageRequest.of(
				pageNumber, 
				pageSize);

		
		
		Query query = null;
		query.fields().exclude("_id");
		query.fields().include("");

	
		List<Map> records = mongo
				.find(query, Map.class, "collection");
		
		
		return records;		
		
	}



	public boolean objectExists(String objectName, String uid) {
		// TODO Auto-generated method stub
		
		Criteria criteria = Criteria.where("id").is(uid);
		Query query = Query.query(criteria);
		
		return mongo.exists(query, Map.class, objectName);
		
	}



	public List<Map<String,Object>> insert(List<Map<String,Object>> records, String loName) {


		final List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
		
		records.forEach((record)->{
					
			Map<String,Object> result;
			
			try {
				
				result = mongo.insert(record, loName);

			}catch(Exception e) {
				
				e.printStackTrace();
				
				//use exception transformers for creting the result.
				 throw new RuntimeException("Errored while inserting record to the DB", e);
						
				
			}
			
			results.add(result);
			
		});
		
		

		
		return results;
	}
	
	
	
	public List<Map<String,Object>> update(List<Map<String,Object>> records){

		List<Map<String,Object>> results = new ArrayList<>();
	
		records.forEach((record)->{
			
			Map<String,Object>  updateResult  = null;
				
			
	
			Query query = null;
			Update updateDef = new Update();
			
			record.forEach((fname, fval) -> {
				
				Object value = fval;
				updateDef.set(fname, value);

			});
			
			
			UpdateResult result = mongo.updateFirst(query, updateDef, "collectionname");
			
			results.add(updateResult);
			
			long updated = result.getModifiedCount();
			long matched = result.getMatchedCount();

		});
			
		return results;
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
