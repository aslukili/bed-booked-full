import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment';
import { AuthResponse } from '../models/AuthResponse';
import { UserAuthRequest } from '../models/UserAuthRequest';
import { UserRegisterRequest } from '../models/UserRegisterRequest';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private readonly apiUrl = environment.apiUrl;
  private token: any;
  private loggedInUsername: any;
  private jwtHelper = new JwtHelperService();

  constructor(private http: HttpClient) { }

  
  public register(user: UserRegisterRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.apiUrl}/auth/register`, user)
  }


  public login(userAuthRequest: UserAuthRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.apiUrl}/auth/login`, userAuthRequest);
  }

  public logout() : void {
    localStorage.removeItem('token');
    this.token = null;
    this.loggedInUsername = null;
  }

  public isUserLoggedIn(): boolean {
    this.loadToken();
    if (this.token != null && this.token != ''){
      if (this.jwtHelper.decodeToken(this.token).sub != null || ''){
        if (!this.jwtHelper.isTokenExpired(this.token)) {
          this.loggedInUsername = this.jwtHelper.decodeToken(this.token).sub;
          return true; 
        }
      }
    } else {
      this.logout();
    }
    return false;
  }


  public storeTokenInLocalStorage(token: string): void {
    this.token = token;
    localStorage.setItem('token', token);
  }

  public loadToken(): void {
    this.token = localStorage.getItem('token');
  }

  public getToken(): string { return this.token; }


}
