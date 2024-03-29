import { Activity, columns } from './columns'
import { DataTable } from './data-table'

const data: Activity[] = [
  {
    id: '1',
    date: new Date('07-24-2005'),
    description: 'Pagamento conta de luz',
    value: 250.95,
    type: 'expense'
  },
  {
    id: '2',
    date: new Date('07-24-2005'),
    description: 'Pagamento conta de agua',
    value: 50.95,
    type: 'expense'
  },
  {
    id: '3',
    date: new Date('07-24-2005'),
    description: 'Pagamento conta de internet',
    value: 200.95,
    type: 'expense'
  },
  {
    id: '4',
    date: new Date('07-24-2005'),
    description: 'Pagamento aluguel',
    value: 500,
    type: 'expense'
  },
  {
    id: '5',
    date: new Date('07-24-2005'),
    description: 'Salario',
    value: 5000,
    type: 'revenue'
  }
]

function getData(): Activity[] {
  // Fetch data from your API here.
  return data
}

export function ActivityTable() {
  const data = getData()

  return (
    <div className="container mx-auto">
      <DataTable columns={columns} data={data} />
    </div>
  )
}
