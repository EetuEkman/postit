import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostitsComponent } from './postits.component';

describe('PostitsComponent', () => {
  let component: PostitsComponent;
  let fixture: ComponentFixture<PostitsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostitsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PostitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
