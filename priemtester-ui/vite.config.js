import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
    plugins: [react()],
    // You don't need to configure anything in vite.config.js for .env files to work.
    // However, below 'define' allows to provide a fallback for undefined variables or customize.
    define: {
        'process.env': process.env,
    },
    test: {
        globals: true,
        environment: 'jsdom',
        setupFiles: './testSetup.js', // Optional: For custom setups
    },
    build: {
        outDir: '../src/main/resources/static/react', // Correct directory
        emptyOutDir: true, // Clear old files
    },

});
