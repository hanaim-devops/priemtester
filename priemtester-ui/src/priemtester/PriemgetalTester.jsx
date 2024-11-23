import React, { useState } from 'react';

const PriemGetalTester = ({ priemFetchService }) => {
    const [kandidaat, setKandidaat] = useState('13');
    const [resultaat, setResultaat] = useState({isPriem: null,});
    const [isOnline, setIsOnline] = useState(true);

    const handleCheckPriem = async () => {
    try {
        const data = await priemFetchService.checkPriem(kandidaat);
        setResultaat({isPriem: data });
        setIsOnline(true);
    } catch (error) {
        setIsOnline(false);
    }
  };

  return (
    <div>
        {!isOnline && (
            <div id="offlineCheck" style={{ color: 'red' }}>
                Server is offline. Probeer het later opnieuw.
            </div>
        )}
      <input
        type="number"
        value={kandidaat}
        onChange={(e) => setKandidaat(e.target.value)}
        placeholder="Voer een getal in"
        aria-label="kandidaat"
      />
      <button onClick={handleCheckPriem} >Check priem</button>
      <div>Is Priem: {resultaat.isPriem ? 'Ja' : 'Nee'}</div>
    </div>
  );
};

export default PriemGetalTester;
