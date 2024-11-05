import React, { useState } from 'react';

const PriemGetalTester = () => {
  const [kandidaat, setKandidaat] = useState('');
  const [resultaat, setResultaat] = useState({
    isPriem: null,
    aantalLoops: 0,
    berekentijd: 0,
    isMemoized: false,
  });

  const handleCheckPriem = async () => {
    const response = await fetch(`/api/isPriem?number=${kandidaat}`);
    const data = await response.json();
    setResultaat(data);
  };

  return (
    <div>
      <input
        type="number"
        value={kandidaat}
        onChange={(e) => setKandidaat(e.target.value)}
        placeholder="Voer een getal in"
        aria-label="kandidaat"
      />
      <button onClick={handleCheckPriem}>Check priem</button>
      <div>Is Priem: {resultaat.isPriem ? 'Ja' : 'Nee'}</div>
      <div>Aantal Loops: {resultaat.aantalLoops}</div>
      <div>Berekentijd: {resultaat.berekentijd} ms</div>
      <div>Is Memoized: {resultaat.isMemoized ? 'Ja' : 'Nee'}</div>
    </div>
  );
};

export default PriemGetalTester;
