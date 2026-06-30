import {
  ChangeDetectionStrategy,
  Component,
  inject
} from '@angular/core';

import { LayoutState } from '../../../core/state/layout.state';

@Component({
  selector: 'app-toolbar',
  standalone: true,
  templateUrl: './toolbar.html',
  styleUrl: './toolbar.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ToolbarComponent {

  protected readonly layout = inject(LayoutState);

  protected readonly pageTitle = 'Dashboard';

  toggleSidebar(): void {

    this.layout.toggleSidebar();

  }

}