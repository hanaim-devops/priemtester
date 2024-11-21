// PriemGetalTester.stories.js
import React from 'react';
import { within, userEvent } from '@storybook/testing-library';
import { rest } from 'msw';
// import { setupWorker } from 'msw/node';
import PriemGetalTester from './PriemgetalTester';

export default {
    title: 'Components/PriemGetalTester',
    component: PriemGetalTester,
    parameters: {
        msw: {
            handlers: [
                rest.get('/api/isPriem', (req, res, ctx) => {
                    const number = req.url.searchParams.get('number');
                    const isPrime = number === '7';
                    return res(
                        ctx.json({
                            isPriem: isPrime,
                            aantalLoops: isPrime ? 3 : 5,
                            berekentijd: isPrime ? 12 : 25,
                            isMemoized: isPrime,
                        })
                    );
                }),
            ],
        },
    },
};

const Template = (args) => <PriemGetalTester {...args} />;

export const Default = Template.bind({});

Default.play = async ({ canvasElement }) => {
    const canvas = within(canvasElement);

    // Vul een getal in dat een priemgetal is, zoals 7
    const input = canvas.getByLabelText('kandidaat');
    await userEvent.type(input, '7');

    // Klik op de "Check priem" knop
    const button = canvas.getByRole('button', { name: /check priem/i });
    await userEvent.click(button);

    // Controleer of de juiste resultaten worden weergegeven
    await canvas.findByText('Is Priem: Ja');
    await canvas.findByText('Aantal Loops: 3');
    await canvas.findByText('Berekentijd: 12 ms');
    await canvas.findByText('Is Memoized: Ja');
};
