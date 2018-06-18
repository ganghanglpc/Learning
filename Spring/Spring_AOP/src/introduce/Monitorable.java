package introduce;

/**
 * 仅定义一个方法，期望通过该接口方法控制业务类性能监视功能的激活和关闭。
 */
public interface Monitorable {
    void setMonitorActive(boolean active);
}
