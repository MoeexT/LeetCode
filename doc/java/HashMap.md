
#结构

数组加链表（红黑树），链表用以解决Hash冲突，当链表长度达到一定值时，转为红黑树。


#构造函数

- `static final float DEFAULT_LOAD_FACTOR = 0.75f;`
- `this.loadFactor = DEFAULT_LOAD_FACTOR;`

#put函数

- `transient Node<K,V>[] table;`
- `int threshold;`
- 

