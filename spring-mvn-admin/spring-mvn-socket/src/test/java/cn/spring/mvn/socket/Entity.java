package cn.spring.mvn.socket;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Entity {
	//
	private int it;
	private Integer Itr;
	private float ft;
	private Float Ftr;
	private short st;
	private Short Str;
	private double dl;
	private Double Dlr;
	private long lo;
	private Long Lor;
	private boolean bo;
	private Boolean Bor;
	private char ch;
	private Character Chr;
	private byte bt;
	private Byte Btr;
	//
	private String string;
	private String[] arr;
	
	private Iterator<?> iterator;
	private ListIterator<?> listIterator;
	private List<?> list;
	private ArrayList<?> arrayList;
	private LinkedList<?> linkedList;
	private Collection<?> collection;
	private Set<?> set;
	private HashSet<?> hashSet;
	private LinkedHashSet<?> linkedHashSet;
	private TreeSet<?> treeSet;
	private Map<?, ?> map;
	private HashMap<?, ?> hsHashMap;
	private LinkedHashMap<?, ?> linkedHsHashMap;
	private TreeMap<?, ?> treeMap;

	private Comparable<?> comparable;
	private Comparator<?> comparator;

	private Collections collections;
	private Array array;
	public int getIt() {
		return it;
	}
	public void setIt(int it) {
		this.it = it;
	}
	public Integer getItr() {
		return Itr;
	}
	public void setItr(Integer itr) {
		Itr = itr;
	}
	public float getFt() {
		return ft;
	}
	public void setFt(float ft) {
		this.ft = ft;
	}
	public Float getFtr() {
		return Ftr;
	}
	public void setFtr(Float ftr) {
		Ftr = ftr;
	}
	public short getSt() {
		return st;
	}
	public void setSt(short st) {
		this.st = st;
	}
	public Short getStr() {
		return Str;
	}
	public void setStr(Short str) {
		Str = str;
	}
	public double getDl() {
		return dl;
	}
	public void setDl(double dl) {
		this.dl = dl;
	}
	public Double getDlr() {
		return Dlr;
	}
	public void setDlr(Double dlr) {
		Dlr = dlr;
	}
	public long getLo() {
		return lo;
	}
	public void setLo(long lo) {
		this.lo = lo;
	}
	public Long getLor() {
		return Lor;
	}
	public void setLor(Long lor) {
		Lor = lor;
	}
	public boolean isBo() {
		return bo;
	}
	public void setBo(boolean bo) {
		this.bo = bo;
	}
	public Boolean getBor() {
		return Bor;
	}
	public void setBor(Boolean bor) {
		Bor = bor;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public Character getChr() {
		return Chr;
	}
	public void setChr(Character chr) {
		Chr = chr;
	}
	public byte getBt() {
		return bt;
	}
	public void setBt(byte bt) {
		this.bt = bt;
	}
	public Byte getBtr() {
		return Btr;
	}
	public void setBtr(Byte btr) {
		Btr = btr;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String[] getArr() {
		return arr;
	}
	public void setArr(String[] arr) {
		this.arr = arr;
	}
	public Iterator<?> getIterator() {
		return iterator;
	}
	public void setIterator(Iterator<?> iterator) {
		this.iterator = iterator;
	}
	public ListIterator<?> getListIterator() {
		return listIterator;
	}
	public void setListIterator(ListIterator<?> listIterator) {
		this.listIterator = listIterator;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public ArrayList<?> getArrayList() {
		return arrayList;
	}
	public void setArrayList(ArrayList<?> arrayList) {
		this.arrayList = arrayList;
	}
	public LinkedList<?> getLinkedList() {
		return linkedList;
	}
	public void setLinkedList(LinkedList<?> linkedList) {
		this.linkedList = linkedList;
	}
	public Collection<?> getCollection() {
		return collection;
	}
	public void setCollection(Collection<?> collection) {
		this.collection = collection;
	}
	public Set<?> getSet() {
		return set;
	}
	public void setSet(Set<?> set) {
		this.set = set;
	}
	public HashSet<?> getHashSet() {
		return hashSet;
	}
	public void setHashSet(HashSet<?> hashSet) {
		this.hashSet = hashSet;
	}
	public LinkedHashSet<?> getLinkedHashSet() {
		return linkedHashSet;
	}
	public void setLinkedHashSet(LinkedHashSet<?> linkedHashSet) {
		this.linkedHashSet = linkedHashSet;
	}
	public TreeSet<?> getTreeSet() {
		return treeSet;
	}
	public void setTreeSet(TreeSet<?> treeSet) {
		this.treeSet = treeSet;
	}
	public Map<?, ?> getMap() {
		return map;
	}
	public void setMap(Map<?, ?> map) {
		this.map = map;
	}
	public HashMap<?, ?> getHsHashMap() {
		return hsHashMap;
	}
	public void setHsHashMap(HashMap<?, ?> hsHashMap) {
		this.hsHashMap = hsHashMap;
	}
	public LinkedHashMap<?, ?> getLinkedHsHashMap() {
		return linkedHsHashMap;
	}
	public void setLinkedHsHashMap(LinkedHashMap<?, ?> linkedHsHashMap) {
		this.linkedHsHashMap = linkedHsHashMap;
	}
	public TreeMap<?, ?> getTreeMap() {
		return treeMap;
	}
	public void setTreeMap(TreeMap<?, ?> treeMap) {
		this.treeMap = treeMap;
	}
	public Comparable<?> getComparable() {
		return comparable;
	}
	public void setComparable(Comparable<?> comparable) {
		this.comparable = comparable;
	}
	public Comparator<?> getComparator() {
		return comparator;
	}
	public void setComparator(Comparator<?> comparator) {
		this.comparator = comparator;
	}
	public Collections getCollections() {
		return collections;
	}
	public void setCollections(Collections collections) {
		this.collections = collections;
	}
	public Array getArray() {
		return array;
	}
	public void setArray(Array array) {
		this.array = array;
	};
}