package com.pdsc.ashpath.domain.dto.request;

import jakarta.validation.constraints.NotNull;

public class LoginRequest
{
  @NotNull(message = "'email' field is required.")
  private String email;

  @NotNull(message = "'password' field is required.")
  private String password;

  public LoginRequest()
  {}

  public LoginRequest(String email, String password)
  {
    this.email = email;
    this.password = password;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPassword()
  {
    return this.password;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LoginRequest other = (LoginRequest) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    return true;
  }
}
