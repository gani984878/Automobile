import { Component, OnInit } from '@angular/core';
import { CarService } from '../../services/car.service';
import { Car } from '../../models/car.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.scss']
})
export class AdminPanelComponent implements OnInit {
  cars: Car[] = [];
  loading = true;
  showForm = false;
  editingCar: Car | null = null;
  carForm: FormGroup;

  constructor(
    private carService: CarService,
    private fb: FormBuilder
  ) {
    this.carForm = this.fb.group({
      name: ['', Validators.required],
      brand: ['', Validators.required],
      type: ['', Validators.required],
      year: [new Date().getFullYear(), [Validators.required, Validators.min(1886)]],
      price: [0, [Validators.required, Validators.min(0)]],
      description: [''],
      imageUrl: [''],
      engineType: [''],
      horsepower: [0],
      torque: [0],
      displacement: [0],
      topSpeed: [0],
      acceleration0To100: [0],
      fuelEconomy: [0],
      techFeatures: [''],
      safetyRating: [0, [Validators.min(0), Validators.max(5)]],
      performanceRating: [0, [Validators.min(0), Validators.max(10)]],
      isFeatured: [false]
    });
  }

  ngOnInit(): void {
    this.loadCars();
  }

  loadCars(): void {
    this.loading = true;
    this.carService.getAllCars().subscribe({
      next: (cars) => {
        this.cars = cars;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  openAddForm(): void {
    this.editingCar = null;
    this.carForm.reset();
    this.showForm = true;
  }

  openEditForm(car: Car): void {
    this.editingCar = car;
    this.carForm.patchValue(car);
    this.showForm = true;
  }

  closeForm(): void {
    this.showForm = false;
    this.editingCar = null;
    this.carForm.reset();
  }

  saveCar(): void {
    if (this.carForm.valid) {
      const carData = this.carForm.value;
      
      if (this.editingCar && this.editingCar.id) {
        this.carService.updateCar(this.editingCar.id, carData).subscribe({
          next: () => {
            this.loadCars();
            this.closeForm();
          }
        });
      } else {
        this.carService.createCar(carData).subscribe({
          next: () => {
            this.loadCars();
            this.closeForm();
          }
        });
      }
    }
  }

  deleteCar(id: number | undefined): void {
    if (id && confirm('Are you sure you want to delete this car?')) {
      this.carService.deleteCar(id).subscribe({
        next: () => {
          this.loadCars();
        }
      });
    }
  }
}

