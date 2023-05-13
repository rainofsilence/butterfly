package cn.silence.butterfly.web.module.sys.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/13 20:32:55
 */
@ApiModel(value = "EnumVO", description = "EnumVO")
public class EnumVO implements Serializable {
    private static final long serialVersionUID = -4449901116162375693L;

    @ApiModelProperty("枚举父类编号")
    private String enumNo;

    @ApiModelProperty("枚举父类名称")
    private String enumName;

    @ApiModelProperty("枚举子类编号")
    private String itemNo;

    @ApiModelProperty("枚举子类名称")
    private String itemName;

    @ApiModelProperty("排序")
    private String sortNo;

    @ApiModelProperty("是否启用")
    private Boolean inuse;

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

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public Boolean getInuse() {
        return inuse;
    }

    public void setInuse(Boolean inuse) {
        this.inuse = inuse;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EnumVO enumVO = (EnumVO) object;
        return Objects.equals(enumNo, enumVO.enumNo) && Objects.equals(enumName, enumVO.enumName) && Objects.equals(itemNo, enumVO.itemNo) && Objects.equals(itemName, enumVO.itemName) && Objects.equals(sortNo, enumVO.sortNo) && Objects.equals(inuse, enumVO.inuse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumNo, enumName, itemNo, itemName, sortNo, inuse);
    }

    @Override
    public String toString() {
        return "EnumVO{" +
                "parentNo='" + enumNo + '\'' +
                ", parentName='" + enumName + '\'' +
                ", subNo='" + itemNo + '\'' +
                ", subName='" + itemName + '\'' +
                ", sortNo='" + sortNo + '\'' +
                ", inuse=" + inuse +
                '}';
    }
}
