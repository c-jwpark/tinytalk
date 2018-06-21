/*
 * Design craft
 * This is a Design craft server.  
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.*;

/**
 * BillInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-03T22:43:20.301Z")
public class BillInformation   {
  @JsonProperty("incallTime")
  private Integer incallTime = null;

  @JsonProperty("outcallTime")
  private Integer outcallTime = null;

  @JsonProperty("sendMsgBytes")
  private Integer sendMsgBytes = null;

  @JsonProperty("receiveMsgBytes")
  private Integer receiveMsgBytes = null;

  @JsonProperty("cost")
  private BigDecimal cost = null;

  public BillInformation incallTime(Integer incallTime) {
    this.incallTime = incallTime;
    return this;
  }

  /**
   * Get incallTime
   * @return incallTime
   **/
  @JsonProperty("incallTime")
  @ApiModelProperty(value = "")
  public Integer getIncallTime() {
    return incallTime;
  }

  public void setIncallTime(Integer incallTime) {
    this.incallTime = incallTime;
  }

  public BillInformation outcallTime(Integer outcallTime) {
    this.outcallTime = outcallTime;
    return this;
  }

  /**
   * Get outcallTime
   * @return outcallTime
   **/
  @JsonProperty("outcallTime")
  @ApiModelProperty(value = "")
  public Integer getOutcallTime() {
    return outcallTime;
  }

  public void setOutcallTime(Integer outcallTime) {
    this.outcallTime = outcallTime;
  }

  public BillInformation sendMsgBytes(Integer sendMsgBytes) {
    this.sendMsgBytes = sendMsgBytes;
    return this;
  }

  /**
   * Get sendMsgBytes
   * @return sendMsgBytes
   **/
  @JsonProperty("sendMsgBytes")
  @ApiModelProperty(value = "")
  public Integer getSendMsgBytes() {
    return sendMsgBytes;
  }

  public void setSendMsgBytes(Integer sendMsgBytes) {
    this.sendMsgBytes = sendMsgBytes;
  }

  public BillInformation receiveMsgBytes(Integer receiveMsgBytes) {
    this.receiveMsgBytes = receiveMsgBytes;
    return this;
  }

  /**
   * Get receiveMsgBytes
   * @return receiveMsgBytes
   **/
  @JsonProperty("receiveMsgBytes")
  @ApiModelProperty(value = "")
  public Integer getReceiveMsgBytes() {
    return receiveMsgBytes;
  }

  public void setReceiveMsgBytes(Integer receiveMsgBytes) {
    this.receiveMsgBytes = receiveMsgBytes;
  }

  public BillInformation cost(BigDecimal cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Get cost
   * @return cost
   **/
  @JsonProperty("cost")
  @ApiModelProperty(value = "")
  public BigDecimal getCost() {
    return cost;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillInformation billInformation = (BillInformation) o;
    return Objects.equals(this.incallTime, billInformation.incallTime) &&
        Objects.equals(this.outcallTime, billInformation.outcallTime) &&
        Objects.equals(this.sendMsgBytes, billInformation.sendMsgBytes) &&
        Objects.equals(this.receiveMsgBytes, billInformation.receiveMsgBytes) &&
        Objects.equals(this.cost, billInformation.cost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(incallTime, outcallTime, sendMsgBytes, receiveMsgBytes, cost);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillInformation {\n");
    
    sb.append("    incallTime: ").append(toIndentedString(incallTime)).append("\n");
    sb.append("    outcallTime: ").append(toIndentedString(outcallTime)).append("\n");
    sb.append("    sendMsgBytes: ").append(toIndentedString(sendMsgBytes)).append("\n");
    sb.append("    receiveMsgBytes: ").append(toIndentedString(receiveMsgBytes)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
  public void calcCost(float inCallChargeRate,float outCallChargeRate, float txtChargeRate) {
	  float tempCost = (inCallChargeRate * this.incallTime)
			  		  +(outCallChargeRate * this.outcallTime)
			          +(txtChargeRate * this.sendMsgBytes) ;
	  this.cost = BigDecimal.valueOf(tempCost);
  }
}

