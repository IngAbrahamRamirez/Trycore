import { ChangeDetectionStrategy, Component } from '@angular/core';

import { SidebarComponent } from '../components/sidebar/sidebar';
import { ToolbarComponent } from '../components/toolbar/toolbar';
import { FooterComponent } from '../components/footer/footer';

import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-shell',
  standalone: true,
  imports: [
    RouterOutlet,
    SidebarComponent,
    ToolbarComponent,
    FooterComponent
  ],
  templateUrl: './shell.html',
  styleUrl: './shell.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ShellComponent {}