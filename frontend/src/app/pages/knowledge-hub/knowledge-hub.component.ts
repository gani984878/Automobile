import { Component } from '@angular/core';

@Component({
  selector: 'app-knowledge-hub',
  templateUrl: './knowledge-hub.component.html',
  styleUrls: ['./knowledge-hub.component.scss']
})
export class KnowledgeHubComponent {
  timelineEvents = [
    { year: '1769', title: 'First Steam Vehicle', description: 'Nicolas-Joseph Cugnot builds the first self-propelled road vehicle - a steam-powered tricycle.' },
    { year: '1886', title: 'First Gasoline Car', description: 'Karl Benz patents the Motorwagen, considered the first true automobile.' },
    { year: '1908', title: 'Mass Production', description: 'Henry Ford introduces the Model T and assembly line production.' },
    { year: '1950s', title: 'Golden Age', description: 'Post-war prosperity leads to iconic designs and powerful engines.' },
    { year: '1997', title: 'Hybrid Revolution', description: 'Toyota Prius introduces hybrid technology to the mass market.' },
    { year: '2008', title: 'Electric Era', description: 'Tesla Roadster proves electric cars can be practical and exciting.' },
    { year: '2020s', title: 'Autonomous Future', description: 'Self-driving technology and AI transform transportation.' }
  ];

  pioneers = [
    { name: 'Karl Benz', contribution: 'Invented the first gasoline-powered automobile', image: '👨‍🔬' },
    { name: 'Henry Ford', contribution: 'Revolutionized manufacturing with assembly line', image: '🏭' },
    { name: 'Ferdinand Porsche', contribution: 'Created iconic sports cars and engineering innovations', image: '🏎️' },
    { name: 'Enzo Ferrari', contribution: 'Founded legendary racing and sports car brand', image: '🏁' },
    { name: 'Elon Musk', contribution: 'Pioneered electric vehicles and sustainable transport', image: '⚡' }
  ];
}

