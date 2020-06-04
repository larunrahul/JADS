package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EditDistanceTest {
    
    EditDistance editDistance;

	@Before
	public void setUp() throws Exception {
		editDistance = new EditDistance();
    }
    
    @Test
    public void findDistance(){
        assertEquals(3, editDistance.findDistance("horse", "ros"));
        assertEquals(5, editDistance.findDistance("intention", "execution"));
    }

    @Test
    public void findDistanceTopDown(){
        assertEquals(3, editDistance.findDistanceTopDown("horse", "ros"));
        assertEquals(5, editDistance.findDistanceTopDown("intention", "execution"));
    }

    @Test
    public void findDistanceBottomUp(){
        assertEquals(3, editDistance.findDistanceBottomUp("horse", "ros"));
        assertEquals(5, editDistance.findDistanceBottomUp("intention", "execution"));
    }

}