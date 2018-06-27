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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CCRequestInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-03T22:43:20.301Z")
public class CCRequestInformation   {
  @JsonProperty("members")
  private List<String> members = null;

  @JsonProperty("startDatetime")
  private Date startDatetime = null;

  @JsonProperty("endDatetime")
  private Date endDatetime = null;

  public CCRequestInformation members(List<String> members) {
    this.members = members;
    return this;
  }

  public CCRequestInformation addMembersItem(String membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<String>();
    }
    this.members.add(membersItem);
    return this;
  }

  /**
   * Get members
   * @return members
   **/
  @JsonProperty("members")
  @ApiModelProperty(value = "")
  public List<String> getMembers() {
    return members;
  }

  public void setMembers(List<String> members) {
    this.members = members;
  }

  public CCRequestInformation startDatetime(Date startDatetime) {
    this.startDatetime = startDatetime;
    return this;
  }

  /**
   * Get startDatetime
   * @return startDatetime
   **/
  @JsonProperty("startDatetime")
  @ApiModelProperty(value = "")
  public Date getStartDatetime() {
    return startDatetime;
  }

  public void setStartDatetime(Date startDatetime) {
    this.startDatetime = startDatetime;
  }

  public CCRequestInformation endDatetime(Date endDatetime) {
    this.endDatetime = endDatetime;
    return this;
  }

  /**
   * time duration (in minutes)
   * @return endDatetime
   **/
  @JsonProperty("endDatetime")
  @ApiModelProperty(value = "time duration (in minutes)")
  public Date getEndDatetime() {
    return endDatetime;
  }

  public void setEndDatetime(Date endDatetime) {
    this.endDatetime = endDatetime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CCRequestInformation ccRequestInformation = (CCRequestInformation) o;
    return Objects.equals(this.members, ccRequestInformation.members) &&
        Objects.equals(this.startDatetime, ccRequestInformation.startDatetime) &&
        Objects.equals(this.endDatetime, ccRequestInformation.endDatetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(members, startDatetime, endDatetime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CCRequestInformation {\n");
    
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
    sb.append("    startDatetime: ").append(toIndentedString(startDatetime)).append("\n");
    sb.append("    endDatetime: ").append(toIndentedString(endDatetime)).append("\n");
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
}

