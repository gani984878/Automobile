/**
 * Car Model Interface
 */
export interface Car {
  id?: number;
  name: string;
  brand: string;
  type: string;
  year: number;
  price: number;
  description?: string;
  imageUrl?: string;
  engineType?: string;
  horsepower?: number;
  torque?: number;
  displacement?: number;
  topSpeed?: number;
  acceleration0To100?: number;
  fuelEconomy?: number;
  techFeatures?: string;
  safetyRating?: number;
  performanceRating?: number;
  isFeatured?: boolean;
  createdAt?: string;
}

/**
 * Dashboard Statistics Interface
 */
export interface DashboardStats {
  horsepowerTrends: { [year: number]: number };
  typeDistribution: { [type: string]: number };
  salesByYear: { [year: number]: number };
  averagePerformanceRating: number;
  totalCars: number;
  totalBrands: number;
  totalTypes: number;
}

/**
 * Car Filter Interface
 */
export interface CarFilter {
  type?: string;
  brand?: string;
  startYear?: number;
  endYear?: number;
  minPrice?: number;
  maxPrice?: number;
}

