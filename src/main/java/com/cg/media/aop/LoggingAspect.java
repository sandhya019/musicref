package com.cg.media.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.cg.media.exception.MediaComposerManagementSystemException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Configuration
public class LoggingAspect {
	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	 
	private ObjectMapper mapper = new ObjectMapper();

	@Before("execution(* com.cg.media.service.ComposerServiceImpl..*(..))")
	public void applicationServLogging(JoinPoint joint) throws MediaComposerManagementSystemException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new MediaComposerManagementSystemException(400, e.getMessage());
		}

	}
	
	/*
	 * @Before("execution(* com.cg.university.service.ProgramsOfferedServ..*(..))")
	 * public void programsOfferedServLogging(JoinPoint joint) throws
	 * MediaComposerManagementSystemException {
	 * mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false); try {
	 * slf4jLogger.info("Begin of - " +
	 * joint.getStaticPart().getSignature().getName() + " method");
	 * slf4jLogger.info("Info Input Parameters -:\n " +
	 * mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
	 * } catch (JsonProcessingException e) { throw new
	 * MediaComposerManagementSystemException(400, e.getMessage()); }
	 * 
	 * }
	 */
	@AfterReturning(pointcut = "execution(* com.cg.media.service.ComposerServiceImpl.*(..))", returning = "result")
	public void serviceSetterMethodLogging(JoinPoint joint, Object result) throws MediaComposerManagementSystemException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new MediaComposerManagementSystemException(400, e.getMessage());
		}
	}
	
	 @AfterReturning(pointcut="execution(* com.cg.media.service.ComposerServiceImpl.getAllComposer(..))", returning="retVal")
	    public void logAfterReturningGetEmployee(Object retVal) throws MediaComposerManagementSystemException
	    {
	        System.out.println("****LoggingAspect.logAfterReturninggetAllComposer() ");
	    }
	 
	    @AfterReturning("execution(* com.cg.media.service.ComposerServiceImpl.createComposer(..))")
	    public void logAfterReturningCreateEmployee() throws MediaComposerManagementSystemException
	    {
	        System.out.println("****LoggingAspect.logAfterReturningCreateEmployee() ");
	    }
	
}