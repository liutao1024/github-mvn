package cn.spring.mvc.base.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
/**
 * @author LiuTao @date 2018年5月25日 下午12:57:04
 * @ClassName: CommUtilHqlFilter 
 * @Description: 公共hibernateSqlStr类
 */
@SuppressWarnings("rawtypes")
public class BaseUtilHqlFilter {
	private HttpServletRequest httpServletRequest;
	private Map<String, Object> map = new HashMap<String, Object>();
	private StringBuffer stringBuffer = new StringBuffer();
	private String str;
	private String ascStr = "asc";

	public BaseUtilHqlFilter() {
	}

	public BaseUtilHqlFilter(HttpServletRequest request) {
		this.httpServletRequest = request;
		addFilter(request);
	}

	public void addSort(String sort) {
		this.str = sort;
	}

	public void addOrder(String order) {
		this.ascStr = order;
	}

	private String a(String paramString) {
		if (StringUtils.equalsIgnoreCase(paramString, "EQ")) {
			return " = ";
		}
		if (StringUtils.equalsIgnoreCase(paramString, "NE")) {
			return " != ";
		}
		if (StringUtils.equalsIgnoreCase(paramString, "LT")) {
			return " < ";
		}
		if (StringUtils.equalsIgnoreCase(paramString, "GT")) {
			return " > ";
		}
		if (StringUtils.equalsIgnoreCase(paramString, "LE")) {
			return " <= ";
		}
		if (StringUtils.equalsIgnoreCase(paramString, "GE")) {
			return " >= ";
		}
		if ((StringUtils.equalsIgnoreCase(paramString, "LK"))
				|| (StringUtils.equalsIgnoreCase(paramString, "RLK"))
				|| (StringUtils.equalsIgnoreCase(paramString, "LLK"))) {
			return " like ";
		}
		return "";
	}

	public String getWhereHql() {
		return this.stringBuffer.toString();
	}

	public String getWhereAndOrderHql() {
		if ((!StringUtils.isBlank(this.str)) && (!StringUtils.isBlank(this.ascStr))) {
			if (this.str.indexOf(".") < 1) {
				this.str = ("t." + this.str);
			}
			this.stringBuffer.append(" order by " + this.str + " " + this.ascStr + " ");
		} else if (this.httpServletRequest != null) {
			String str1 = this.httpServletRequest.getParameter("sort");
			String str2 = this.httpServletRequest.getParameter("order");
			if (!StringUtils.isBlank(str1)) {
				this.str = str1;
			}
			if (!StringUtils.isBlank(str2)) {
				this.ascStr = str2;
			}
			if ((!StringUtils.isBlank(this.str))
					&& (!StringUtils.isBlank(this.ascStr))) {
				if (this.str.indexOf(".") < 1) {
					this.str = ("t." + this.str);
				}
				this.stringBuffer.append(" order by " + this.str + " " + this.ascStr + " ");
			}
		}

		return this.stringBuffer.toString();
	}

	public Map<String, Object> getParams() {
		return this.map;
	}

	public void addFilter(HttpServletRequest request) {
		Enumeration localEnumeration = request.getParameterNames();
		while (localEnumeration.hasMoreElements()) {
			String str1 = (String) localEnumeration.nextElement();
			String str2 = request.getParameter(str1);
			addFilter(str1, str2);
		}
	}

	public void addFilter(String name, String value) {
		if ((name != null) && (value != null) && (name.startsWith("QUERY_"))) {
			String[] arrayOfString = StringUtils.split(name, "_");
			if (arrayOfString.length == 4) {
				String str1 = arrayOfString[1].replaceAll("#", ".");
				String str2 = arrayOfString[2];
				String str3 = arrayOfString[3];
				String str4 = UUID.randomUUID().toString().replace("-", "");

				if (this.stringBuffer.toString().indexOf(" where 1=1") < 0) {
					this.stringBuffer.append("  where 1=1 ");
				}

				this.stringBuffer.append(" and " + str1 + " " + a(str3) + " :param" + str4
						+ " ");
				this.map.put("param" + str4, a(str2, str3, value));
			}
		}
	}

	private Object a(String paramString1, String paramString2, String paramString3) {
		if (StringUtils.equalsIgnoreCase(paramString1, "S")) {
			if (StringUtils.equalsIgnoreCase(paramString2, "LK"))
				paramString3 = "%%" + paramString3 + "%%";
			else if (StringUtils.equalsIgnoreCase(paramString2, "RLK"))
				paramString3 = paramString3 + "%%";
			else if (StringUtils.equalsIgnoreCase(paramString2, "LLK")) {
				paramString3 = "%%" + paramString3;
			}
			return paramString3;
		}
		if (StringUtils.equalsIgnoreCase(paramString1, "L")) {
			return Long.valueOf(Long.parseLong(paramString3));
		}
		if (StringUtils.equalsIgnoreCase(paramString1, "I")) {
			return Integer.valueOf(Integer.parseInt(paramString3));
		}
		if (StringUtils.equalsIgnoreCase(paramString1, "D")) {
			try {
				return DateUtils.parseDate(paramString3, new String[] {
						"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
						"yyyy-MM-dd", "yyyy/MM/dd" });
			} catch (ParseException localParseException) {
				localParseException.printStackTrace();
			}
		}
		if (StringUtils.equalsIgnoreCase(paramString1, "ST")) {
			return Short.valueOf(Short.parseShort(paramString3));
		}
		if (StringUtils.equalsIgnoreCase(paramString1, "BD")) {
			return BigDecimal.valueOf(Long.parseLong(paramString3));
		}
		if (StringUtils.equalsIgnoreCase(paramString1, "FT")) {
			return Float.valueOf(Float.parseFloat(paramString3));
		}
		return null;
	}
}