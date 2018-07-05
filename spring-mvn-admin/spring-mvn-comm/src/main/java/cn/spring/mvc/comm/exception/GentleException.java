package cn.spring.mvc.comm.exception;

/**
 * @author LiuTao @date 2018年5月22日 下午10:18:05
 * @ClassName: GentleException 
 * @Description: TODO(自定义异常,继承不检查异常类,实现优雅异常)
 */
public final class GentleException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    //错误码
    private String errCode;
    //错误信息
    private String errMsg;

    public GentleException() {
        super();
    }
    
    public GentleException(String errCode) {
        super();
        this.setErrCode(errCode);
    }
    
    public GentleException(String errCode, String errMsg) {
        super();
        this.setErrCode(errCode);
        this.setErrMsg(errMsg);
    }

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
    
}
