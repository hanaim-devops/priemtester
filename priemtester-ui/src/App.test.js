import { render, screen } from '@testing-library/react';
import App from './App.jsx';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/Is Priem/i);
  expect(linkElement).toBeInTheDocument();
});
