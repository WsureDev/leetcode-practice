package top.wsure.leetcode.design.pattern.singleton;

/**
 * FileName: SingletonPattern
 * Author:   wsure
 * Date:     2021/6/29 11:17 上午
 * Description:单例 - 静态内部类
 */
public class SingletonByInnerClass {
    private SingletonByInnerClass(){}

    public static class SingletonHolder{
        public static final SingletonByInnerClass INSTANCE = new SingletonByInnerClass();
    }

    public static SingletonByInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
