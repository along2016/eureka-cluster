package com.cloud.common.user.sysUser.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cloud.common.auth.entity.IUser;
import com.cloud.common.base.entity.BaseEntity;
import com.cloud.common.user.sysJob.entity.vo.SysJobVO;
import com.cloud.common.user.sysOffice.entity.vo.SysOfficeVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.List;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Collection;
import java.util.List;

@ApiModel("系统用户VO")
public class UserVO extends BaseEntity implements IUser {
    private static final long serialVersionUID = 1L;
    @NotBlank(
            message = "用户名不能为空"
    )
    @ApiModelProperty(
            value = "登录名",
            name = "username",
            example = "test"
    )
    private String username;
    @ApiModelProperty(
            value = "密码",
            name = "password",
            example = "test"
    )
    private String password;
    @JsonIgnore
    @ApiModelProperty(
            value = "加密盐",
            name = "salt"
    )
    private String salt;
    @ApiModelProperty(
            value = "角色",
            name = "authorities"
    )
    private List<AuthorityVO> authorities;
    @ApiModelProperty(
            value = "机构",
            name = "office"
    )
    @TableField(
            exist = false
    )
    private SysOfficeVO office;
    @ApiModelProperty(
            value = "岗位",
            name = "jobs"
    )
    private List<SysJobVO> jobs;
    @ApiModelProperty(
            value = "工号",
            name = "no"
    )
    private String no;
    @NotBlank(
            message = "姓名不能为空"
    )
    @ApiModelProperty(
            value = "姓名",
            name = "name"
    )
    private String name;
    @Email
    @ApiModelProperty(
            value = "邮箱",
            name = "email"
    )
    private String email;
    @ApiModelProperty(
            value = "电话",
            name = "phone"
    )
    private String phone;
    @ApiModelProperty(
            value = "用户头像",
            name = "avatar"
    )
    private String avatar;
    @ApiModelProperty(
            value = "是否可登录",
            name = "login_flag"
    )
    @TableField("login_flag")
    private String loginFlag;

    public void setAuthorities(Collection<AuthorityVO> authorities) {
        this.authorities = (List)authorities;
    }

    public UserVO() {
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getSalt() {
        return this.salt;
    }

    @Override
    public List<AuthorityVO> getAuthorities() {
        return this.authorities;
    }

    public SysOfficeVO getOffice() {
        return this.office;
    }

    public List<SysJobVO> getJobs() {
        return this.jobs;
    }

    public String getNo() {
        return this.no;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getLoginFlag() {
        return this.loginFlag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setOffice(SysOfficeVO office) {
        this.office = office;
    }

    public void setJobs(List<SysJobVO> jobs) {
        this.jobs = jobs;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserVO)) {
            return false;
        } else {
            UserVO other = (UserVO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label155: {
                    Object this$username = this.getUsername();
                    Object other$username = other.getUsername();
                    if (this$username == null) {
                        if (other$username == null) {
                            break label155;
                        }
                    } else if (this$username.equals(other$username)) {
                        break label155;
                    }

                    return false;
                }

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                Object this$salt = this.getSalt();
                Object other$salt = other.getSalt();
                if (this$salt == null) {
                    if (other$salt != null) {
                        return false;
                    }
                } else if (!this$salt.equals(other$salt)) {
                    return false;
                }

                label134: {
                    Object this$authorities = this.getAuthorities();
                    Object other$authorities = other.getAuthorities();
                    if (this$authorities == null) {
                        if (other$authorities == null) {
                            break label134;
                        }
                    } else if (this$authorities.equals(other$authorities)) {
                        break label134;
                    }

                    return false;
                }

                label127: {
                    Object this$office = this.getOffice();
                    Object other$office = other.getOffice();
                    if (this$office == null) {
                        if (other$office == null) {
                            break label127;
                        }
                    } else if (this$office.equals(other$office)) {
                        break label127;
                    }

                    return false;
                }

                label120: {
                    Object this$jobs = this.getJobs();
                    Object other$jobs = other.getJobs();
                    if (this$jobs == null) {
                        if (other$jobs == null) {
                            break label120;
                        }
                    } else if (this$jobs.equals(other$jobs)) {
                        break label120;
                    }

                    return false;
                }

                Object this$no = this.getNo();
                Object other$no = other.getNo();
                if (this$no == null) {
                    if (other$no != null) {
                        return false;
                    }
                } else if (!this$no.equals(other$no)) {
                    return false;
                }

                label106: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label106;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label106;
                    }

                    return false;
                }

                Object this$email = this.getEmail();
                Object other$email = other.getEmail();
                if (this$email == null) {
                    if (other$email != null) {
                        return false;
                    }
                } else if (!this$email.equals(other$email)) {
                    return false;
                }

                label92: {
                    Object this$phone = this.getPhone();
                    Object other$phone = other.getPhone();
                    if (this$phone == null) {
                        if (other$phone == null) {
                            break label92;
                        }
                    } else if (this$phone.equals(other$phone)) {
                        break label92;
                    }

                    return false;
                }

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
                    return false;
                }

                Object this$loginFlag = this.getLoginFlag();
                Object other$loginFlag = other.getLoginFlag();
                if (this$loginFlag == null) {
                    if (other$loginFlag != null) {
                        return false;
                    }
                } else if (!this$loginFlag.equals(other$loginFlag)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof UserVO;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Object $salt = this.getSalt();
        result = result * 59 + ($salt == null ? 43 : $salt.hashCode());
        Object $authorities = this.getAuthorities();
        result = result * 59 + ($authorities == null ? 43 : $authorities.hashCode());
        Object $office = this.getOffice();
        result = result * 59 + ($office == null ? 43 : $office.hashCode());
        Object $jobs = this.getJobs();
        result = result * 59 + ($jobs == null ? 43 : $jobs.hashCode());
        Object $no = this.getNo();
        result = result * 59 + ($no == null ? 43 : $no.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $loginFlag = this.getLoginFlag();
        result = result * 59 + ($loginFlag == null ? 43 : $loginFlag.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "UserVO(username=" + this.getUsername() + ", password=" + this.getPassword() + ", salt=" + this.getSalt() + ", authorities=" + this.getAuthorities() + ", office=" + this.getOffice() + ", jobs=" + this.getJobs() + ", no=" + this.getNo() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ", avatar=" + this.getAvatar() + ", loginFlag=" + this.getLoginFlag() + ")";
    }
}
