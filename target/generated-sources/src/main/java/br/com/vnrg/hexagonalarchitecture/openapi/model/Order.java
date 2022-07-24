package br.com.vnrg.hexagonalarchitecture.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Order
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-24T14:40:26.707468566-03:00[America/Sao_Paulo]")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("orderType")
  private Integer orderType;

  @JsonProperty("orderState")
  private Integer orderState;

  @JsonProperty("orderDescription")
  private String orderDescription;

  @JsonProperty("orderValue")
  private BigDecimal orderValue;

  @JsonProperty("productId")
  private Long productId;

  @JsonProperty("productItems")
  private Integer productItems;

  @JsonProperty("productDescription")
  private String productDescription;

  @JsonProperty("customerId")
  private UUID customerId;

  public Order orderType(Integer orderType) {
    this.orderType = orderType;
    return this;
  }

  /**
   * Get orderType
   * minimum: 1
   * @return orderType
  */
  @Min(1) 
  @Schema(name = "orderType", required = false)
  public Integer getOrderType() {
    return orderType;
  }

  public void setOrderType(Integer orderType) {
    this.orderType = orderType;
  }

  public Order orderState(Integer orderState) {
    this.orderState = orderState;
    return this;
  }

  /**
   * Get orderState
   * minimum: 1
   * @return orderState
  */
  @Min(1) 
  @Schema(name = "orderState", required = false)
  public Integer getOrderState() {
    return orderState;
  }

  public void setOrderState(Integer orderState) {
    this.orderState = orderState;
  }

  public Order orderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
    return this;
  }

  /**
   * Get orderDescription
   * @return orderDescription
  */
  
  @Schema(name = "orderDescription", required = false)
  public String getOrderDescription() {
    return orderDescription;
  }

  public void setOrderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
  }

  public Order orderValue(BigDecimal orderValue) {
    this.orderValue = orderValue;
    return this;
  }

  /**
   * Get orderValue
   * @return orderValue
  */
  @Valid 
  @Schema(name = "orderValue", required = false)
  public BigDecimal getOrderValue() {
    return orderValue;
  }

  public void setOrderValue(BigDecimal orderValue) {
    this.orderValue = orderValue;
  }

  public Order productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  
  @Schema(name = "productId", required = false)
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Order productItems(Integer productItems) {
    this.productItems = productItems;
    return this;
  }

  /**
   * Get productItems
   * minimum: 1
   * @return productItems
  */
  @Min(1) 
  @Schema(name = "productItems", required = false)
  public Integer getProductItems() {
    return productItems;
  }

  public void setProductItems(Integer productItems) {
    this.productItems = productItems;
  }

  public Order productDescription(String productDescription) {
    this.productDescription = productDescription;
    return this;
  }

  /**
   * Get productDescription
   * @return productDescription
  */
  
  @Schema(name = "productDescription", required = false)
  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Order customerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @Valid 
  @Schema(name = "customerId", required = false)
  public UUID getCustomerId() {
    return customerId;
  }

  public void setCustomerId(UUID customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.orderType, order.orderType) &&
        Objects.equals(this.orderState, order.orderState) &&
        Objects.equals(this.orderDescription, order.orderDescription) &&
        Objects.equals(this.orderValue, order.orderValue) &&
        Objects.equals(this.productId, order.productId) &&
        Objects.equals(this.productItems, order.productItems) &&
        Objects.equals(this.productDescription, order.productDescription) &&
        Objects.equals(this.customerId, order.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderType, orderState, orderDescription, orderValue, productId, productItems, productDescription, customerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    sb.append("    orderType: ").append(toIndentedString(orderType)).append("\n");
    sb.append("    orderState: ").append(toIndentedString(orderState)).append("\n");
    sb.append("    orderDescription: ").append(toIndentedString(orderDescription)).append("\n");
    sb.append("    orderValue: ").append(toIndentedString(orderValue)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productItems: ").append(toIndentedString(productItems)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

