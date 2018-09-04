package cn.spring.mvn.comm.tools;

import org.springframework.context.ApplicationContext;

import cn.spring.mvn.base.entity.SystemSequence;
import cn.spring.mvn.base.entity.service.SystemSequenceService;
import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;

public class SequenceTool {
	private static ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
	private static SystemSequenceService systemSequenceServiceImpl = applicationContext.getBean(SystemSequenceService.class);
	/**
	 * @author LiuTao @date 2018年6月19日 下午10:53:46 
	 * @Title: getSequence 
	 * @Description: 根据序列类型获取序列号
	 * @param sequenceType
	 * @return
	 */
	public static String getSequence(String sequenceType){
		String sequence = null;
		SystemSequence systemSequence = systemSequenceServiceImpl.selectOne(sequenceType);
		if(CommUtil.isNotNull(systemSequence)){
			String begin = systemSequence.getSequenceBegin();
			String middle = systemSequence.getSequenceMiddle();
			String end = systemSequence.getSequenceEnd();
			int step = systemSequence.getSequenceStep();
			Long b = Long.parseLong(begin);
			Long m = Long.parseLong(middle);
			Long e = Long.parseLong(end);
			e = e + step;
			String newEnd = String.valueOf(e);
			if(newEnd.length() > end.length()){
				m = m + 1;
			}
			newEnd = crayyBit(end, newEnd);
			String newMiddle = String.valueOf(m);
			if(newMiddle.length() > middle.length()){
				b = b + 1;
			}
			String newBegin = String.valueOf(b);
			systemSequence.setSequenceBegin(newBegin);
			systemSequence.setSequenceMiddle(newMiddle);
			systemSequence.setSequenceEnd(newEnd);
			systemSequenceServiceImpl.saveOrUpdate(systemSequence);
			sequence = begin + middle + end;
		}
		return sequence;
	}
	/**
	 * @author LiuTao @date 2018年6月19日 下午10:54:28 
	 * @Title: crayyBit 
	 * @Description: 处理 
	 * @param oldStr
	 * @param newStr
	 * @return
	 */
	public static String crayyBit(String oldStr, String newStr){
		String desStr = "";
		if(newStr.length() > oldStr.length()){
			byte[] arr = oldStr.getBytes();
			for (int i = 0; i < arr.length; i++) {
				if(i == 0){
					arr[i] = '1';
				}else {
					arr[i] = '0';
				}
			}
			desStr = new String(arr);
		}else {
			desStr = newStr;
		}
		return desStr;
	}
}
