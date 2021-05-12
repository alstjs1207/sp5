package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
//@Order(2)
public class CacheAspect {

	private Map<Long, Object> cache = new HashMap<>();

	@Pointcut("execution(public * chap08..*(long))")
	public void cacheTarget() {
		System.out.println("cacheTarget");
	}

	@Before("execution(public * chap08..*(..))")
	public void before(JoinPoint joinPoint) throws Throwable {

		System.out.println("Test 시작!!");
	}

	@AfterThrowing(pointcut = "execution(public * chap07..*(..))", throwing = "exception")
	public void throwsFail(JoinPoint joinPoint, Exception exception) {
		System.out.println(" exception!!!"+exception.getMessage());
	}
	
	@Around("cacheTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		Long num = (Long) joinPoint.getArgs()[0];
		if (cache.containsKey(num)) {
			System.out.printf("CacheAspect: Cache에서 구함[%d]\n", num);
			return cache.get(num);
		}

		Object result = joinPoint.proceed();
		cache.put(num, result);
		System.out.printf("CacheAspect: Cache에 추가[%d]\n", num);
		return result;
	}

}
