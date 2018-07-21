package com.turnmarker.next.controllers;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.springframework.web.client.RestTemplate;

public class AbstractTestBase {
	
	protected RestTemplate restTemplate = new RestTemplate();
	
	public RestTemplate getRestTemplate() {
		
		if (null == this.restTemplate) {
			
			restTemplate = new RestTemplate();
			
		}
		
		// ELSE ALWAYS:
		return this.restTemplate;
		
	}
	
    @Rule
    public TestRule testWatcher = new TestWatcher() {
        
    	@Override
        public Statement apply(Statement stmt, Description desc) {
        
    		String tmethod = desc.getMethodName();
    		String tclass = desc.getClassName();
    		
    		trace(String.format("apply() --> method called for Description: %s:%s", tclass, tmethod));
    		
    		trace("apply() --> calling super()");
    		
    		// CALL AND RETURN:
    		return super.apply(stmt, desc);
        
    	}

        @Override
        protected void succeeded(Description desc) {
        
        	trace("Test " + desc.getDisplayName() + " passed");
        
        }

		@Override
        protected void failed(Throwable t, Description desc) {
        
			trace("Test " + desc.getDisplayName() + " failed");
        
        }

        @Override
        protected void skipped(AssumptionViolatedException ave, Description desc) {
        
        	trace("skipped() --> method called()");
        	
        }

        @Override
        protected void starting(Description desc) {
            
        	trace("starting() --> calling super()");
        	
        	// CALL:
        	super.starting(desc);
        
        }

        @Override
        protected void finished(Description desc) {

        	trace("finished() --> calling super()");

        	// CALL:
        	super.finished(desc);
    
        }

    };	

    protected void trace(String message) {

    	System.out.println(message);
		
	}

}
