import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue
} from '@/components/ui/select'

export function InsertActivityForm() {
  return (
    <div className="flex p-8 space-x-2">
      <Input type="date" className="max-w-[10rem] shadow-md"></Input>
      <Input
        type="text"
        className="shadow-md"
        placeholder="Insira a descrição da atividade..."
      ></Input>
      <Input
        type="number"
        className="max-w-[8rem] shadow-md"
        placeholder="Insira o valor..."
      ></Input>

      <Select>
        <SelectTrigger className="w-80 shadow-md">
          <SelectValue placeholder="Selecione o tipo" />
        </SelectTrigger>
        <SelectContent>
          <SelectItem value="0">Entrada</SelectItem>
          <SelectItem value="1">Saída</SelectItem>
        </SelectContent>
      </Select>

      <Button>Inserir</Button>
    </div>
  )
}
