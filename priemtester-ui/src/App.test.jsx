import React from 'react';
import { describe, it, expect} from 'vitest';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import App from './App';

describe('App Component', () => {
  it('renders the PriemGetalTester component', () => {
    render(<App />);

    // Check for PriemGetalTester elements
    const inputElement = screen.getByPlaceholderText(/voer een getal in/i);
    const buttonElement = screen.getByRole('button', { name: /check priem/i });

    expect(inputElement).toBeInTheDocument();
    expect(buttonElement).toBeInTheDocument();
  });

  it('renders the header', () => {
    render(<App />);

    const headerElement = screen.getByRole('banner');
    expect(headerElement).toBeInTheDocument();
  });
});
