package cn.spring.mvn.basic.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.transform.AliasedTupleSubsetResultTransformer;
/**
 * @author LiuTao @date 2018年5月25日 下午12:55:03
 * @ClassName: CommUtilResultTransFormer 
 * @Description: 公共变化类 模版工具
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BasicUtilResultTransFormer extends AliasedTupleSubsetResultTransformer {
	private static final long serialVersionUID = 1L;
	public static final BasicUtilResultTransFormer INSTANCE = new BasicUtilResultTransFormer();
	final boolean addAlias;
	boolean filled;
	public static final int LOWER = 1;
	public static final int UPPER = 2;
	public static final int DEFAULT_CASE = 0;
	final int charCase;
	private List<String> aliases;

	public BasicUtilResultTransFormer(List<String> columns, int charCase) {
		if ((charCase != 0) && (columns == null)) {
			columns = new ArrayList();
		}
		this.aliases = columns;
		this.addAlias = (this.aliases != null);
		this.charCase = charCase;
	}

	private BasicUtilResultTransFormer() {
		this.addAlias = false;
		this.filled = true;
		this.charCase = 0;
	}

	
	public Object transformTuple(Object[] tuple, String[] aliases) {
		if ((!this.filled) && (this.addAlias)) {
			this.filled = true;
			for (int i = 0; i < aliases.length; i++) {
				String str1 = aliases[i];
				if (str1 == null) {
					str1 = "";
				}
				this.aliases.add(this.charCase == 1 ? str1.toLowerCase()
						: this.charCase == 2 ? str1.toUpperCase() : str1);
			}

		}

		LinkedHashMap localLinkedHashMap = new LinkedHashMap(tuple.length);
		int j;
		String str2;
		if (this.aliases != null) {
			for (j = 0; j < tuple.length; j++) {
				str2 = (String) this.aliases.get(j);
				if (str2 != null)
					localLinkedHashMap.put(str2, tuple[j]);
			}
		} else {
			for (j = 0; j < tuple.length; j++) {
				str2 = aliases[j];
				if (str2 != null) {
					localLinkedHashMap.put(str2, tuple[j]);
				}
			}
		}

		return localLinkedHashMap;
	}

	public boolean isTransformedValueATupleElement(String[] aliases,
			int tupleLength) {
		return false;
	}

	private Object readResolve() {
		return INSTANCE;
	}
}
