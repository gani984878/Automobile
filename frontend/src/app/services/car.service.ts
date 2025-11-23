import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car, DashboardStats, CarFilter } from '../models/car.model';

/**
 * Service for car-related API calls
 */
@Injectable({
  providedIn: 'root'
})
export class CarService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  /**
   * Get all cars
   */
  getAllCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/cars`);
  }

  /**
   * Get car by ID
   */
  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(`${this.apiUrl}/cars/${id}`);
  }

  /**
   * Get featured cars
   */
  getFeaturedCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/cars/featured`);
  }

  /**
   * Filter cars
   */
  filterCars(filter: CarFilter): Observable<Car[]> {
    let params = new HttpParams();
    
    if (filter.type) params = params.set('type', filter.type);
    if (filter.brand) params = params.set('brand', filter.brand);
    if (filter.startYear) params = params.set('startYear', filter.startYear.toString());
    if (filter.endYear) params = params.set('endYear', filter.endYear.toString());
    if (filter.minPrice) params = params.set('minPrice', filter.minPrice.toString());
    if (filter.maxPrice) params = params.set('maxPrice', filter.maxPrice.toString());

    return this.http.get<Car[]>(`${this.apiUrl}/cars/filter`, { params });
  }

  /**
   * Get distinct types
   */
  getTypes(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/cars/types`);
  }

  /**
   * Get distinct brands
   */
  getBrands(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/cars/brands`);
  }

  /**
   * Create a new car
   */
  createCar(car: Car): Observable<Car> {
    return this.http.post<Car>(`${this.apiUrl}/cars`, car);
  }

  /**
   * Update a car
   */
  updateCar(id: number, car: Car): Observable<Car> {
    return this.http.put<Car>(`${this.apiUrl}/cars/${id}`, car);
  }

  /**
   * Delete a car
   */
  deleteCar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/cars/${id}`);
  }

  /**
   * Get dashboard statistics
   */
  getDashboardStats(): Observable<DashboardStats> {
    return this.http.get<DashboardStats>(`${this.apiUrl}/dashboard/stats`);
  }
}

