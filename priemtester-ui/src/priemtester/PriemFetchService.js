const rootUrl = import.meta.env.VITE_API_BASE_URL;

export default class PriemFetchService {

  async checkPriem(number) {
    const response = await fetch(rootUrl + 'priem', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ number }),
    });
    if (!response.ok) {
      throw new Error('Failed to fetch');
    }
    return response.json();
  }
}

