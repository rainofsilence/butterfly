package cn.silence.butterfly.web.module.sys.model.po;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/13 21:44:57
 */
public class EnumDO implements Serializable {
    private static final long serialVersionUID = 7087352932008206767L;

    private String enumNo;
    private String enumName;
    private String itemNo;
    private String itemName;
    private String orderByClause;

    public String getEnumNo() {
        return enumNo;
    }

    public void setEnumNo(String enumNo) {
        this.enumNo = enumNo;
    }

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EnumDO enumDO = (EnumDO) object;
        return Objects.equals(enumNo, enumDO.enumNo) && Objects.equals(enumName, enumDO.enumName) && Objects.equals(itemNo, enumDO.itemNo) && Objects.equals(itemName, enumDO.itemName) && Objects.equals(orderByClause, enumDO.orderByClause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumNo, enumName, itemNo, itemName, orderByClause);
    }

    @Override
    public String toString() {
        return "EnumDO{" +
                "enumNo='" + enumNo + '\'' +
                ", enumName='" + enumName + '\'' +
                ", itemNo='" + itemNo + '\'' +
                ", itemName='" + itemName + '\'' +
                ", orderByClause='" + orderByClause + '\'' +
                '}';
    }
}
