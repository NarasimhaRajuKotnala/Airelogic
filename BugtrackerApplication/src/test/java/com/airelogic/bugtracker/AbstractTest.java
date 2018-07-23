package com.airelogic.bugtracker;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)



@SpringBootTest
public abstract class AbstractTest {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
