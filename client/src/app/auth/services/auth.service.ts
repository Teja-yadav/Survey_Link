<<<<<<< HEAD
import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from "../../../environments/environment";
import { Observable } from "rxjs";
import { Supplier } from "../../supplylink/types/Supplier";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private loginUrl = `${environment.apiUrl}`;


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  constructor(private http: HttpClient) { }

  login(user: Partial<Supplier>): Observable<{ [key: string]: string }> {
    return this.http.post<{ token: string }>(
      `${this.loginUrl}/user/login`,
      user,
      this.httpOptions
    );
  }

  getToken() {
    return localStorage.getItem("token");
  }
  getRole() {
    return localStorage.getItem("role");
  }


  createUser(user: Supplier): Observable<Supplier> {
    return this.http.post<Supplier>(`${this.loginUrl}/user/register`, user);
  }
}
=======
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

/**
 * Day-22+ AuthService
 * You already have login, createUser, getToken...
 * We add helpers for role & userId used by Day-23 UI.
 */
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly base = typeof window !== 'undefined' && window.location
    ? window.location.origin
    : '';

  constructor(private http: HttpClient) {}

  login(payload: { username: string; password: string }): Observable<any> {
    const url = `${this.base}/context.html/user/login`;
    return this.http.post(url, payload);
  }

  createUser(user: any): Observable<any> {
    const url = `${this.base}/context.html/user/register`;
    return this.http.post(url, user);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }
  setToken(token: string): void {
    localStorage.setItem('token', token);
  }

  // Day 23 helpers
  getRole(): string | null {
    return localStorage.getItem('role');
  }
  setRole(role: string): void {
    localStorage.setItem('role', role);
  }
  getUserId(): number | null {
    const v = localStorage.getItem('userId');
    return v ? Number(v) : null;
  }
  setUserId(id: number): void {
    localStorage.setItem('userId', String(id));
  }
  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('role');
    localStorage.removeItem('userId');
  }
}
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
