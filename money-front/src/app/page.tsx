import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import { CircleDollarSign } from 'lucide-react'

export default function Home() {
  return (
    <main>
      <div className="flex pb-60 items-center h-screen">
        <div className="container space-y-2 p-8 max-w-md rounded-xl bg-gray-50 shadow-md">
          <span className="flex items-center gap-2">
            <CircleDollarSign className="text-gray-500" size={48} />
            <h1 className="uppercase text-gray-600 font-bold text-xl">
              Money Manager
            </h1>
          </span>
          <Input type="email" placeholder="Digite seu email" />
          <Input type="password" placeholder="Digite sua senha" />
          <Button>Enviar</Button>
        </div>
      </div>
    </main>
  )
}
