import { Component, OnInit } from '@angular/core';
import { CarService } from '../../services/car.service';
import { Car, CarFilter } from '../../models/car.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-car-explorer',
  templateUrl: './car-explorer.component.html',
  styleUrls: ['./car-explorer.component.scss']
})
export class CarExplorerComponent implements OnInit {
  cars: Car[] = [];
  filteredCars: Car[] = [];
  loading = true;
  
  // Filter options
  types: string[] = [];
  brands: string[] = [];
  filter: CarFilter = {};
  
  // UI state
  showFilters = false;
  currentPage = 1;
  itemsPerPage = 12;

  constructor(
    private carService: CarService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadCars();
    this.loadFilterOptions();
  }

  loadCars(): void {
    this.loading = true;
    this.carService.getAllCars().subscribe({
      next: (cars) => {
        this.cars = cars;
        this.filteredCars = cars;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  loadFilterOptions(): void {
    this.carService.getTypes().subscribe(types => {
      this.types = types;
    });
    this.carService.getBrands().subscribe(brands => {
      this.brands = brands;
    });
  }

  applyFilters(): void {
    this.loading = true;
    this.carService.filterCars(this.filter).subscribe({
      next: (cars) => {
        this.filteredCars = cars;
        this.currentPage = 1;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  clearFilters(): void {
    this.filter = {};
    this.loadCars();
  }

  viewCarDetails(carId: number | undefined): void {
    if (carId) {
      this.router.navigate(['/car', carId]);
    }
  }

  get paginatedCars(): Car[] {
    const start = (this.currentPage - 1) * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    return this.filteredCars.slice(start, end);
  }

  get totalPages(): number {
    return Math.ceil(this.filteredCars.length / this.itemsPerPage);
  }

  changePage(page: number): void {
    this.currentPage = page;
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}

