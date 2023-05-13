package cn.silence.butterfly.web.module.sys.model.request;

import cn.silence.butterfly.core.util.result.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/13 21:00:58
 */
@ApiModel(value = "EnumPageRequest", description = "EnumPageRequest")
public class EnumPageRequest extends BasePageRequest {
    private static final long serialVersionUID = 3474412867423918294L;

    @ApiModelProperty("枚举编号")
    private String enumNo;
    @ApiModelProperty("枚举名称")
    private String enumName;
    @ApiModelProperty("枚举子项编号")
    private String itemNo;
    @ApiModelProperty("枚举子项名称")
    private String itemName;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EnumPageRequest that = (EnumPageRequest) object;
        return Objects.equals(enumNo, that.enumNo) && Objects.equals(enumName, that.enumName) && Objects.equals(itemNo, that.itemNo) && Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumNo, enumName, itemNo, itemName);
    }

    @Override
    public String toString() {
        return "EnumPageRequest{" +
                "enumNo='" + enumNo + '\'' +
                ", enumName='" + enumName + '\'' +
                ", itemNo='" + itemNo + '\'' +
                ", itemName='" + itemName + '\'' +
                "} " + super.toString();
    }
}
